package com.fraunhoferproject.commonservices;

import org.springframework.stereotype.Service;

@Service
public class UnixService {
    
    public long generateUnixCurrentTimestamp(){
        return System.currentTimeMillis() / 1000L;
    }
}
