package com.mingle.jmx;

/**
 * @author mingle
 * @Version 16/12/2
 */
public class MessageEngine implements MessageEngineMXBean {
    private final Message message = Echo.msg;


    public void stop() {
        Echo.running = false;
    }


    public boolean isPaused() {
        return Echo.pause;
    }

    public void pause(boolean pause) {
        Echo.pause = pause;
    }

    public Message getMessage() {
        return this.message;
    }

    public void changeMessage(Message m) {
        this.message.setBody(m.getBody());
        this.message.setTitle(m.getTitle());
        this.message.setBy(m.getBy());
    }
}
