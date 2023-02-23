package dev.pingerboard.service;

import dev.pingerboard.model.Server;

import java.io.IOException;
import java.util.Collection;

public interface ServerService {
    Server createServer(Server server);
    Server pingServer(String ipAddress) throws IOException;
    Collection<Server> getListOfServers(int limit);
    Server getServer(Long id);
    Server updateServer(Server server);
    Boolean deleteServer(Long id);
}
