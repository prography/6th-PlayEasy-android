package com.prography.playeasy.util.playeasyServiceManager;

public class PlayeasyServiceManager {
    private static Object service = null;

    private PlayeasyServiceManager() {}

    // 객체 요청 실행되면
    public static <T> T getInstance(Class<T> serviceClazz) {
        // 서비스 객체가 없거나 지금 요청받은 클래스와 다르면 새 객체 생성
        if (service == null || !serviceClazz.isInstance(service)) {
            try {
                service = serviceClazz.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

        // 해당 객체로 캐스팅 해서 반환
        return serviceClazz.cast(service);
    }
}
