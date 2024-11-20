package com.es.seguridadsession.exception;

/**
 * The type Error msg for client.
 */
public class ErrorMsgForClient {
    private String msg;
    private String uri;

    /**
     * Instantiates a new Error msg for client.
     *
     * @param msg the msg
     * @param uri the uri
     */
    public ErrorMsgForClient(String msg, String uri) {
        this.msg = msg;
        this.uri = uri;
    }

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets msg.
     *
     * @param msg the msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Gets uri.
     *
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets uri.
     *
     * @param uri the uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }
}
