package tiemens.util.resources;

import java.io.InputStream;

public interface ResourceLoader
{
    public String getLoaderId();
    
    public InputStream getAsInputStream(String pathToResource);

}
