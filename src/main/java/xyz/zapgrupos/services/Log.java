package xyz.zapgrupos.services;

class Log {

    public Log(String msg, Object... params){
        System.out.println(
                String.format(msg, params)
        );
    }
}
