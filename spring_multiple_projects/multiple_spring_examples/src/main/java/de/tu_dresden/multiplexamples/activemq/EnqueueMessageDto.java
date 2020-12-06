//package tu_dresden.multiple_spring_examples.activemq;
//
//import org.joda.time.DateTime;
//
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class EnqueueMessageDto {
//	
//	private long eventId;
//	
//    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
//    @JsonSerialize(using = CustomDateTimeSerializer.class)
//    
//    private DateTime eventDate;
//}
