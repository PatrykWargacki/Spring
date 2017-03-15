package springproject.model;

import java.util.List;

public interface MessageRepository {
	List<Message> findMessage(long max, int count);
}
