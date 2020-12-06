//package tu_dresden.multiple_spring_examples.activemq;
//
//import java.io.IOException;
//
//import org.joda.time.DateTime;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//
//public class CustomDateTimeSerializer extends JsonSerializer<DateTime>{
//
//	@Override
//	public void serialize(DateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
//		// TODO Auto-generated method stub
//		if(value == null)
//		{
//			
//		} else 
//		{
//			gen.writeObject(convertTimeToDto(value));
//		}
//	}
//
//	public static Long convertTimeToDto(DateTime value)
//	{
//		return value.getMillis();
//	}
//}
