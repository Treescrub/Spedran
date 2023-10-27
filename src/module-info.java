module Spedran {
    requires unirest.java;
    requires org.apache.logging.log4j;

    exports treescrub.spedran.data;
    exports treescrub.spedran.data.run;
    exports treescrub.spedran.data.user;
    exports treescrub.spedran.data.variables;
    exports treescrub.spedran.data.game;
    exports treescrub.spedran.data.category;
    exports treescrub.spedran.data.leaderboard;
    exports treescrub.spedran.api;
    exports treescrub.spedran.api.request;
    exports treescrub.spedran.api.request.category;
    exports treescrub.spedran.api.request.developer;
    exports treescrub.spedran.api.request.engine;
    exports treescrub.spedran.api.request.game;
    exports treescrub.spedran.api.request.gametype;
    exports treescrub.spedran.api.request.genre;
    exports treescrub.spedran.api.request.guest;
    exports treescrub.spedran.api.request.leaderboard;
    exports treescrub.spedran.api.request.level;
    exports treescrub.spedran.api.request.platform;
    exports treescrub.spedran.api.request.publisher;
    exports treescrub.spedran.api.request.region;
    exports treescrub.spedran.api.request.run;
    exports treescrub.spedran.api.request.series;
    exports treescrub.spedran.api.request.user;
    exports treescrub.spedran.api.request.variable;
}