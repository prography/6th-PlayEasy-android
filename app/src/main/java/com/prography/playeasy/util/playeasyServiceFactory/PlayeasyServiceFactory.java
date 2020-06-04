package com.prography.playeasy.util.playeasyServiceFactory;

public class PlayeasyServiceFactory {
    private static PlayeasyService service = null;

    private PlayeasyServiceFactory() {}

    public static <T> T getService(Class<T> serviceClazz) {
        if (service == null || !serviceClazz.isInstance(service)) {
            try {
                service = (PlayeasyService)serviceClazz.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

        return serviceClazz.cast(service);
    }
}
