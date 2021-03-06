package graphql.servlet;

import org.dataloader.DataLoaderRegistry;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.websocket.server.HandshakeRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GraphQLContext {
    private HttpServletRequest httpServletRequest;
    private HandshakeRequest handshakeRequest;

    private Subject subject;
    private Map<String, List<Part>> files;

    private DataLoaderRegistry dataLoaderRegistry;

    public GraphQLContext(HttpServletRequest httpServletRequest, HandshakeRequest handshakeRequest, Subject subject) {
        this.httpServletRequest = httpServletRequest;
        this.handshakeRequest = handshakeRequest;
        this.subject = subject;
    }

    public GraphQLContext(HttpServletRequest httpServletRequest) {
        this(httpServletRequest, null, null);
    }

    public GraphQLContext(HandshakeRequest handshakeRequest) {
        this(null, handshakeRequest, null);
    }

    public GraphQLContext() {
        this(null, null, null);
    }

    public Optional<HttpServletRequest> getHttpServletRequest() {
        return Optional.ofNullable(httpServletRequest);
    }

    public Optional<Subject> getSubject() {
        return Optional.ofNullable(subject);
    }

    public Optional<HandshakeRequest> getHandshakeRequest() {
        return Optional.ofNullable(handshakeRequest);
    }

    public Optional<Map<String, List<Part>>> getFiles() {
        return Optional.ofNullable(files);
    }

    public void setFiles(Map<String, List<Part>> files) {
        this.files = files;
    }

    public Optional<DataLoaderRegistry> getDataLoaderRegistry() {
        return Optional.ofNullable(dataLoaderRegistry);
    }

    public void setDataLoaderRegistry(DataLoaderRegistry dataLoaderRegistry) {
        this.dataLoaderRegistry = dataLoaderRegistry;
    }
}
