package com.mc.transportmanager.service;

import org.springframework.stereotype.Service;

import com.mc.transportmanager.entity.Message;
import com.mc.transportmanager.repository.MessageRepository;

@Service
public class MessageService extends GenericService<Message> {
	public MessageService(MessageRepository messageRepository) {
		super(messageRepository);
	}
}
