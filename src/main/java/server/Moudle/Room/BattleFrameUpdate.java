package server.Moudle.Room;

import server.msg.auto.CSBattleLogicFrameMsg;
import server.msg.auto.SCBattleLogicFrame;

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
    private int m_iFrame;
    private Callback m_Callback;

    public void Initialize(Callback callback,int tickRate,int syncRate)
    {

    }
    public void OnClientCmd(CSBattleLogicFrameMsg msg)
    {

    }
    public void Tick()
    {

    }
    private void DoTick()
    {
        ++m_iFrame;
        m_Callback.BroadcastCmd(null);
    }
}
