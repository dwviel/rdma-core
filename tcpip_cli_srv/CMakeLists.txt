# Shared example files

rdma_executable(tcpip_client tcpip_client.c)
#target_link_libraries(cmtime LINK_PRIVATE rdmacm ${CMAKE_THREAD_LIBS_INIT} rdmacm_tools)

rdma_executable(tcpip_server tcpip_server.c)
#target_link_libraries(mckey LINK_PRIVATE rdmacm ${CMAKE_THREAD_LIBS_INIT})

