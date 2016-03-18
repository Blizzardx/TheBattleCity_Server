package server.Moudle.Item;

import server.msg.auto.ItemGenFundamental;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/18.
 */
public class GenItemManager
{
    private ItemGenFundamental info;
    private ArrayList<ItemInfo> m_CurrentItemList;
    private int m_CurrentTime;
    private ArrayList<Integer> m_CurrentUsingPosList;

    public void Initialize(ItemGenFundamental info)
    {
        this.info = info;
        m_CurrentItemList = new ArrayList<ItemInfo>();
        m_CurrentUsingPosList = new ArrayList<Integer>();

        for(int i=0;i<info.positionId.size();++i)
        {
            m_CurrentUsingPosList.add(info.positionId.get(i));
        }
    }
    public boolean Update()
    {
        return false;
    }
    public ArrayList<ItemInfo> RandomGen()
    {
        ArrayList<ItemInfo> res = null;
        return res;
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
    private void RemoveUsingPosList(int posId)
    {
        for(int j=0;j<m_CurrentUsingPosList.size();++j)
        {
            if(m_CurrentUsingPosList.get(j) == posId)
            {
                return;
            }
        }
        m_CurrentUsingPosList.add(posId);
    }
}
