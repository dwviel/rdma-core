# Shared example files

# lib dir for rdma
link_directories(${BUILD_LIB})	


# TCP
rdma_executable(tcpip_client tcpip_client.c)
#target_link_libraries(cmtime LINK_PRIVATE rdmacm ${CMAKE_THREAD_LIBS_INIT} rdmacm_tools)

rdma_executable(tcpip_server tcpip_server.c)
#target_link_libraries(mckey LINK_PRIVATE rdmacm ${CMAKE_THREAD_LIBS_INIT})

rdma_executable(tcpip_client_loop tcpip_client_loop.c)

rdma_executable(tcpip_server_loop tcpip_server_loop.c)


# UDP
rdma_executable(udpip_listener udpip_listener.c)
rdma_executable(udpip_talker udpip_talker.c)

#target_link_libraries(udpip_listener)
#target_link_libraries(udpip_talker)

rdma_executable(udpip_listener_r udpip_listener_r.c)
rdma_executable(udpip_talker_r udpip_talker_r.c)

#target_link_libraries( udpip_listener_r rdmacm)
#target_link_libraries( udpip_talker_r rdmacm)

target_link_libraries( udpip_listener_r ${BUILD_LIB}/librdmacm.so manage_recursive)
target_link_libraries( udpip_talker_r ${BUILD_LIB}/librdmacm.so manage_recursive)
