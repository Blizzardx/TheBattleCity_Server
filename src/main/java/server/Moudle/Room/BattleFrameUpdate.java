package server.Moudle.Room;

import server.msg.auto.*;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/28.
 */
public class BattleFrameUpdate
{
    public interface Callback
    {
        void BroadcastCmd(SCBattleLogicFrame msg);
    }
    private int m_iTickRate;
    private int m_iSyncRate;
    private int m_iCurrentDuringFrame;
    private int m_iCurrentDuringTime;
    private int m_iFrame;
    private long m_iLastFrameTime;
    private Callback m_Callback;
    private ArrayList<BattleFrameData> m_FrameDataList;
    private BattleFrameData m_CurrentFrameData;

    public void Initialize(Callback callback,int tickRate,int syncRate)
    {
        m_Callback = callback;
        m_iTickRate = tickRate;
        m_iSyncRate = syncRate;
        m_iFrame = 0;
        m_iCurrentDuringFrame = 0;
        m_iLastFrameTime = 0;
        m_FrameDataList = new ArrayList<BattleFrameData>();
    }
    public void OnClientCmd(int charId,CSBattleLogicFrame msg)
    {
        int size = m_CurrentFrameData.charCommandList.size();
        for(int i=0;i<size;++i)
        {
            if(m_CurrentFrameData.charCommandList.get(i).charId == charId)
            {
                m_CurrentFrameData.charCommandList.get(i).commandList.add(msg.commandData);
            }
        }
        // add new cmd
        BattleCharCommand cmd = new BattleCharCommand();
        cmd.charId = charId;
        cmd.commandList = new ArrayList<BattleCommandData>();
        cmd.commandList.add(msg.commandData);
    }
    public void Tick()
    {
        long currentTime = System.currentTimeMillis();
        if(m_iLastFrameTime == 0)
        {
            m_iLastFrameTime = currentTime;
        }
        m_iCurrentDuringTime += currentTime - m_iLastFrameTime;
        m_iLastFrameTime = currentTime;
        if(m_iCurrentDuringTime >= m_iTickRate)
        {
            m_iCurrentDuringTime = 0;
            DoFrame();
        }
    }
    private void DoFrame()
    {
        ++m_iFrame;
        BattleFrameData frameData = new BattleFrameData();
        frameData.frameIndex = m_iFrame;
        frameData.charCommandList = new ArrayList<BattleCharCommand>();
        m_FrameDataList.add(frameData);
        m_CurrentFrameData = frameData;
        ++ m_iCurrentDuringFrame;
        if(m_iCurrentDuringFrame >= m_iSyncRate)
        {
            m_iCurrentDuringFrame = 0;
            DoSync();
        }
    }
    private void DoSync()
    {
        SCBattleLogicFrame msg = new SCBattleLogicFrame();
        msg.battleFrameDataList = m_FrameDataList;
        m_FrameDataList = new ArrayList<BattleFrameData>();
        m_Callback.BroadcastCmd(msg);
    }
}
