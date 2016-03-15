package server.Handler;

/**
 * Created by Administrator on 2016/3/15.
 */
public class CustomServerMessageId
{
    /* 0 - 10000*/
    public static final int S_MIN = 0;

    public static final int S_LOSE_CLIENT = 1;

    public static final int S_MAX = 2;

    public static boolean IsSupportMessage(int id)
    {
        return id > S_MIN && id < S_MAX;
    }
}
