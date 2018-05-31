/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_exchange.api_services.dao.message;

import com.service_exchange.api_services.dao.message.messagedtos.MessageComplaintDto;
import com.service_exchange.api_services.dao.message.messagedtos.MessagePrivateDto;
import com.service_exchange.api_services.dao.message.messagedtos.MessageTransactionDto;
import com.service_exchange.api_services.factories.AppFactory;
import com.service_exchange.entities.Message;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author esraa
 */
public class CustomMessageInterfaceImpl implements CustomMessageInterface{

    @PersistenceContext
    EntityManager entityManager;
 
    private int limit=20;
    private String tableName="message";
    @Override
    public List<MessagePrivateDto> findAllPrivateChatMessages(Integer user1Id, Integer user2Id, Integer pageNum) {
   
      Query query = entityManager.createNativeQuery("select * from "+tableName +" where (sender_id=? and receiver_id=?) or(sender_id=? and receiver_id=?) ", Message.class);
       query.setParameter(1, user1Id.intValue());
        query.setParameter(2, user2Id.intValue());
        query.setParameter(3, user2Id.intValue());
        query.setParameter(4, user1Id.intValue());
       
        //Paginering
        query.setFirstResult(pageNum*limit);
        query.setMaxResults(limit);
        
        List<Message> resultList =query.getResultList();
        List<MessagePrivateDto> resultDtoList =new ArrayList();
        resultList.forEach(obj->resultDtoList.add(AppFactory.mapToDto(obj, MessagePrivateDto.class)));
        if(resultList.size()>0)
        {
            return resultDtoList;
        }
        else 
        {
            return null;
        }
    }

    @Override
    public List<MessageComplaintDto> getAllComplaintMessages(Integer complaintId, Integer pageNum) {
     
        
      Query query = entityManager.createNativeQuery("select * from "+tableName +" where complaint_id=? ", Message.class);
       query.setParameter(1, complaintId.intValue());
       
        //Paginering
        query.setFirstResult(pageNum*limit);
        query.setMaxResults(limit);
        
        List<Message> resultList =query.getResultList();
        List<MessageComplaintDto> resultDtoList =new ArrayList();
        resultList.forEach(obj->resultDtoList.add(AppFactory.mapToDto(obj, MessageComplaintDto.class)));
        if(resultList.size()>0)
        {
            return resultDtoList;
        }
        else 
        {
            return null;
        }
    }

    @Override
    public List<MessageTransactionDto> getAllTransactionMessages(Integer transactionId, Integer pageNum) {
  
    Query query = entityManager.createNativeQuery("select * from "+tableName +" where transaction_id=? ", Message.class);
       query.setParameter(1, transactionId.intValue());
       
        //Paginering
        query.setFirstResult(pageNum*limit);
        query.setMaxResults(limit);
        
        List<Message> resultList =query.getResultList();
        List<MessageTransactionDto> resultDtoList =new ArrayList();
        resultList.forEach(obj->resultDtoList.add(AppFactory.mapToDto(obj, MessageTransactionDto.class)));
        if(resultList.size()>0)
        {
            return resultDtoList;
        }
        else 
        {
            return null;
        }
    }
    
}