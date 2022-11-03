package utils;

public class Constants {
    public static class API{
        public static String URL = "http://localhost:8086";
    }
    public static class API_SOFTWARE{
        public static String GET_LIST_SOFTWARE = "/api/client/software/list";
        public static String GET_DETAIL_SOFTWARE = "/api/client/software/detail";
        public static String GET_ALL_SOFTWARE = "/api/client/software/all";
        public static String CREATE_SOFTWARE = "/api/client/software/create";
        public static String UPDATE_SOFTWARE = "/api/client/software/update";
        public static String DELETE_SOFTWARE = "/api/client/software/delete";
    }

    public static class API_COMPANY{
        public static String GET_ALL_COMPANY_OPTION = "/api/client/company/all-option";
    }
}
