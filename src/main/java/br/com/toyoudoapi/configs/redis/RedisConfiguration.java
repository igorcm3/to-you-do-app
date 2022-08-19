package br.com.toyoudoapi.configs.redis;

/**
 * Classe de configuyração do Redis
 * Não foi utilizado a autoconfig via spring proiperies pois confltia o @Bean cacheManager do Redis com o JPA
 * Ocasionando erro nos @Repository. Desta forma, configurando pro esta classe, não ocorre este erro
 */
//@Configuration
//@EnableCaching
//@PropertySource("classpath:application.properties")
public class RedisConfiguration {
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public LettuceConnectionFactory redisConnectionFactory() {
//        RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
//        redisConf.setHostName(env.getProperty("spring.redis.host"));
//        redisConf.setPort(Integer.parseInt(env.getProperty("spring.redis.port")));
//        //redisConf.setPassword(RedisPassword.of(env.getProperty("spring.redis.password")));
//        return new LettuceConnectionFactory(redisConf);
//    }
//
//    @Bean
//    public RedisCacheConfiguration cacheConfiguration() {
//        return RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofSeconds(600))
//                .disableCachingNullValues();
//    }
//    @Bean
//    public RedisCacheManager cacheManager() {
//        return RedisCacheManager.builder(redisConnectionFactory())
//                .cacheDefaults(cacheConfiguration())
//                .transactionAware()
//                .build();
//    }
}
