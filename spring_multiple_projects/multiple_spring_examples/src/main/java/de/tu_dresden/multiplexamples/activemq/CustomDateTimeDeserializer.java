//package tu_dresden.multiple_spring_examples.activemq;
//
//import java.io.IOException;
//
//import org.apache.commons.lang3.StringUtils;
//import org.joda.time.DateTime;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//
//public class CustomDateTimeDeserializer extends JsonDeserializer<DateTime>{
//	
//	@Override
//	public DateTime deserialize(JsonParser jasonParser, DeserializationContext context) throws IOException 
//	{
//		if(StringUtils.isBlank(jasonParser.getValueAsString())) 
//		{
//			return null;
//		}
//		try 
//		{
//			return new DateTime(Long.parseLong(jasonParser.getValueAsString()));
//		} catch(IllegalArgumentException e)
//		{
//			e.printStackTrace();
//		}
//		return null;
//	}
//}
