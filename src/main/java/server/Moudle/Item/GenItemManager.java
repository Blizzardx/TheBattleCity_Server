package server.Moudle.Item;

import server.Moudle.Random.CustomRandom;
import server.msg.auto.ItemGenFundamental;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2016/3/18.
 */
public class GenItemManager
{
    private ItemGenFundamental m_ItemInfo;
    private ArrayList<ItemInfo> m_CurrentItemList;
    private long m_CurrentTime;
    private ArrayList<Integer> m_CurrentUsingPosList;

    public void Initialize(ItemGenFundamental info)
    {
        this.m_ItemInfo = info;
        m_CurrentItemList = new ArrayList<ItemInfo>();
        m_CurrentUsingPosList = new ArrayList<Integer>();

        for(int i=0;i<info.positionId.size();++i)
        {
            m_CurrentUsingPosList.add(info.positionId.get(i));
        }
    }
    public ArrayList<ItemInfo> GetInitItem()
    {
        return RandomGenItem(m_ItemInfo.initItemCount);
    }
    public boolean Update()
    {
        long time = System.currentTimeMillis();
        long delatTime =time - m_CurrentTime;
        if(delatTime < m_ItemInfo.triggerDeltaTime * 1000)
        {
            return false;
        }
        if(m_CurrentItemList.size() >= m_ItemInfo.maxCount)
        {
            return false;
        }

        //reset time
        m_CurrentTime = time;
        return true;
    }
    public ArrayList<ItemInfo> RandomGen()
    {
        int min = m_ItemInfo.genPreTimeItemCountMin;
        int max = m_ItemInfo.genPreTimeItemCountMax;
        int tmpMax = m_ItemInfo.maxCount - m_CurrentItemList.size();
        if(max > tmpMax)
        {
            max = tmpMax;
        }

        int randomCount = CustomRandom.RandomIntInclude(min,max);

        return RandomGenItem(randomCount);
    }
    public boolean TryUseItem(int id,int posId)
    {
        for(int i=0;i<m_CurrentItemList.size();++i)
        {
            ItemInfo elem = m_CurrentItemList.get(i);
            if(elem.m_iItemId == id && elem.m_iPositionId == posId)
            {
                // try remove
                m_CurrentItemList.remove(i);
                AddUsingPosList(posId);
                return true;
            }
        }
        return false;
    }
    private void AddUsingPosList(int posId)
    {
        for (int j = 0; j < m_CurrentUsingPosList.size(); ++j)
        {
            if (m_CurrentUsingPosList.get(j) == posId)
            {
                return;
            }
        }
        m_CurrentUsingPosList.add(posId);
    }
    private void RemoveUsingPosList(int posId)
    {
        for(int j=0;j<m_CurrentUsingPosList.size();++j)
        {
            if(m_CurrentUsingPosList.get(j) == posId)
            {
                // do remove
                m_CurrentUsingPosList.remove(j);
                break;
            }
        }
    }
    private ArrayList<ItemInfo> RandomGenItem(int count)
    {
        ArrayList<ItemInfo> res = new ArrayList<ItemInfo>();
        for(int i=0;i<count&&m_CurrentUsingPosList.size()>0;++i)
        {
            ItemInfo item = RandomItem();
            res.add(item);
            RemoveUsingPosList(item.m_iPositionId);
            m_CurrentItemList.add(item);
        }
        return res;
    }
    private ItemInfo RandomItem()
    {
        ItemInfo res = new ItemInfo();

        // get random position
        res.m_iPositionId = m_CurrentUsingPosList.get(CustomRandom.RandomInt(0,m_CurrentUsingPosList.size()));
        res.m_iItemId = m_ItemInfo.itemList.get(CustomRandom.RandomInt(0,m_ItemInfo.itemList.size()));
        return res;
    }
}
