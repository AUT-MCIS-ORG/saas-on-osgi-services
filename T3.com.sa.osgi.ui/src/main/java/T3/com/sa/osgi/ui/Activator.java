package T3.com.sa.osgi.ui;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import com.sa.osgi.system.UIService;
import java.util.Dictionary;
import java.util.Properties;
import org.osgi.framework.ServiceRegistration;

public class Activator
implements BundleActivator
{
    private ServiceRegistration<?> serviceReg;
    
    public void start( final BundleContext ctx ) throws Exception
    {   
        Dictionary properties = new Properties();
        properties.put("vendor", "T3");
        serviceReg = ctx.registerService(UIService.class.getName(), new T3UIService(), properties);
    }

    public void stop( BundleContext ctx ) throws Exception
    {
        if( serviceReg != null){
            serviceReg.unregister();
        }
    }
    
}
