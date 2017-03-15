package springproject.data;

import java.util.List;

import springproject.model.Message;

public interface MessageRepository {
	List<Message> findMessage(long max, int count);
	Message showOne(long messageId);
}
