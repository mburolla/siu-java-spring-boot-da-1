package com.xpanxion.java.springboot.da1.demo.service.student2;

public class MemberIdNotFoundException extends Exception {
    public MemberIdNotFoundException() {
        super();
    }

    public MemberIdNotFoundException(final String message) {
        super(message);
    }
}
