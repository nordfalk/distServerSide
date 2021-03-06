package services;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;

@Path("")
public class Root {

    @GET
    public String getRoot() throws IOException {
        //Initialize Mustache renderer
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("index.mustache");
        //Set some data
        HashMap<String, Object> mustacheData = new HashMap<String, Object>();
        mustacheData.put("time", new Date());
        //render template with data
        StringWriter writer = new StringWriter();
        m.execute(writer, mustacheData).flush();
        return writer.toString();
    }
}
