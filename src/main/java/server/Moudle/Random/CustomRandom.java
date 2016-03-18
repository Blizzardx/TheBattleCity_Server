package server.Moudle.Random;

import java.util.Random;

/**
 * Created by Administrator on 2016/3/18.
 */
public class CustomRandom
{
    public static int seed = 0;
    private static Random m_Random = new Random();
    public static int RandomIntInclude(int min,int max)
    {
        //include max
        max += 1;
        return RandomInt(min,max);
    }
    public static int RandomInt(int min,int max)
    {
        if(min >= max)
        {
            return max;
        }
        m_Random.setSeed(++seed);
        //random position
        int delta = max - min;
        int res = Math.abs(m_Random.nextInt() % delta) + min;
        if(seed >= Integer.MAX_VALUE)
        {
            seed = 0;
        }
        return res;
    }
}
