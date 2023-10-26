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
    exports treescrub.spedran.api.request.run;
    exports treescrub.spedran.api.request;
    exports treescrub.spedran.api.request.user;
}