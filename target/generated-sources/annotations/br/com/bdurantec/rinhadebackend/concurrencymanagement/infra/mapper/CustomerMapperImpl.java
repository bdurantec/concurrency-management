package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.enums.TransactionTypeEnum;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity.CustomerEntity;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity.TransactionEntity;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-20T23:16:34-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    private final DatatypeFactory datatypeFactory;

    public CustomerMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public Customer toModel(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Long limit = null;
        Long balance = null;

        limit = customerEntity.getLimitBalance();
        balance = customerEntity.getBalance();

        Customer customer = new Customer( balance, limit );

        if ( customer.getTransactions() != null ) {
            List<Transaction> list = transactionEntityListToTransactionList( customerEntity.getTransactions() );
            if ( list != null ) {
                customer.getTransactions().addAll( list );
            }
        }

        return customer;
    }

    private XMLGregorianCalendar dateToXmlGregorianCalendar( Date date ) {
        if ( date == null ) {
            return null;
        }

        GregorianCalendar c = new GregorianCalendar();
        c.setTime( date );
        return datatypeFactory.newXMLGregorianCalendar( c );
    }

    private static LocalDateTime xmlGregorianCalendarToLocalDateTime( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        if ( xcal.getYear() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMonth() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getDay() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getHour() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMinute() != DatatypeConstants.FIELD_UNDEFINED
        ) {
            if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED
                && xcal.getMillisecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond(),
                    Duration.ofMillis( xcal.getMillisecond() ).getNano()
                );
            }
            else if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond()
                );
            }
            else {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute()
                );
            }
        }
        return null;
    }

    protected Transaction transactionEntityToTransaction(TransactionEntity transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }

        Long value = null;
        TransactionTypeEnum type = null;
        String description = null;
        LocalDateTime dateTime = null;

        if ( transactionEntity.getValue() != null ) {
            value = Long.parseLong( transactionEntity.getValue() );
        }
        if ( transactionEntity.getType() != null ) {
            type = Enum.valueOf( TransactionTypeEnum.class, transactionEntity.getType() );
        }
        description = transactionEntity.getDescription();
        dateTime = xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( transactionEntity.getDateTime() ) );

        Transaction transaction = new Transaction( value, type, description, dateTime );

        return transaction;
    }

    protected List<Transaction> transactionEntityListToTransactionList(List<TransactionEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Transaction> list1 = new ArrayList<Transaction>( list.size() );
        for ( TransactionEntity transactionEntity : list ) {
            list1.add( transactionEntityToTransaction( transactionEntity ) );
        }

        return list1;
    }
}
