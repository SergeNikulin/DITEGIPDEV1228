package pages.docs;

public class SomeVariables {
    public static String readmeBlockCode = "<link  href=\"http://egiptest.mos.ru/jsapi/lib/ol-5.2.0.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
            "<link  href=\"http://egiptest.mos.ru/jsapi/lib/ol-ext-3.0.1.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
            "<!-- ... -->\n" +
            "<script src=\"http://egiptest.mos.ru/jsapi/lib/proj4-2.4.4.js\"></script>\n" +
            "<script src=\"http://egiptest.mos.ru/jsapi/lib/ol-5.2.0.js\"></script>\n" +
            "<script src=\"http://egiptest.mos.ru/jsapi/lib/ol-ext-3.0.1.js\"></script>\n" +
            "<script src=\"http://egiptest.mos.ru/jsapi/dist/egip.js\"></script>\n" +
            "<script >\n" +
            "  egip.setConfig({\n" +
            "\n" +
            "    /** `baseURL` will be prepended to `url` unless `url` is absolute.\n" +
            "     *  It can be convenient to set `baseURL` for an instance of axios to pass relative URLs\n" +
            "     *  to methods of that instance.\n" +
            "     *  https://github.com/axios/axios\n" +
            "    */\n" +
            "    baseURL: 'http://example.com/',\n" +
            "\n" +
            "    apiKey: 'exampleApiKey',\n" +
            "\n" +
            "    /**\n" +
            "     * `withCredentials` indicates whether or not cross-site Access-Control requests\n" +
            "     *  should be made using credentials\n" +
            "     *  https://github.com/axios/axios\n" +
            "    */\n" +
            "    withCredentials: true\n" +
            "  })\n" +
            "\n" +
            "  window.egip.api...\n" +
            "  window.egip.layers...\n" +
            "</script>";

    public static String layersWMS = "https://gost-jira.atlassian.net/wiki/spaces/EGIPAPIDOC/pages/436699311/API";

    public static String layersBlockCode = "1\n" +
            "2\n" +
            "3\n" +
            "4\n" +
            "5\n" +
            "6\n" +
            "7\n" +
            "8\n" +
            "9\n" +
            "10\n" +
            "11\n" +
            "12\n" +
            "13\n" +
            "14\n" +
            "15\n" +
            "16\n" +
            "17\n" +
            "18\n" +
            "19\n" +
            "var example;\n" +
            "(function (example) {\n" +
            "    egip.setConfig({\n" +
            "        baseURL: '/',\n" +
            "        apiKey: 'exampleApiKey'\n" +
            "    });\n" +
            "    async function main() {\n" +
            "        await egip.api.login({\n" +
            "            login: 'sys',\n" +
            "            password: '!23456QWEqwe'\n" +
            "        })\n" +
            "            .catch(err => console.warn(err));\n" +
            "        const map = egip.layers.createMap({\n" +
            "            target: 'map',\n" +
            "            controls: ol.control.defaults({\n" +
            "                attribution: false\n" +
            "            }),\n" +
            "        });\n" +
            "        egip.layers.switchMapTo3857(map);";
}
