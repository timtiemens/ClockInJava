/**
 * 
 */
package tiemens.clock.simpleimage;

import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * @author tim
 *
 */
public class SimpleImageClockMain
    extends JFrame
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ConvertCharacterToImage c2img = 
            ConvertCharacterToImageFactory.getDefault();
        
        String disp = "11223344";
        DisplayPanel dp = new DisplayPanel(disp.length(),
                                           disp,
                                           null, 
                                           c2img, 
                                           250, 90);
     
        
        new SimpleImageClockMain(dp);
        
        Spinner sp = new Spinner(dp);
        sp.go();
        System.out.println("Hello");
    }

    public SimpleImageClockMain(DisplayPanel dp)
    {
        
        JFrame f = this;
        
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(dp);
        f.pack();
        f.setSize(300, 100);
        f.setVisible(true);


    }
    
    public static class Spinner
        implements Runnable
    {
        final private DisplayPanel dp;
        private Thread thread;
        private Iterator<ConvertCharacterToImage> iter;
        public Spinner(DisplayPanel indp)
        {
            dp = indp;
            thread = new Thread(this);
            iter = null;
        }
        public void go()
        {
            thread.start();
        }
        public void run()
        {
            while (true)
            {
                try
                {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                    break;
                }
                ConvertCharacterToImage next = getNext();
                dp.setDigitsImages(next);
            }
              
        }
        private ConvertCharacterToImage getNext()
        {
            if ((iter == null) ||
                (! iter.hasNext()))
            {
                iter = ConvertCharacterToImageFactory.iterateAll();
            }
            return iter.next();
        }
    }
}
