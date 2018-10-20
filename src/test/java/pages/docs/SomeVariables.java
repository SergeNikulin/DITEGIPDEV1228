package pages.docs;

public class SomeVariables {
    public static String readmeBlockCode = "<script src=\"http://egiptest.gost-group.com/jsapi/dist/egip.api.js\"></script>\n" +
            "<script >\n" +
            "\n" +
            "  const egip = window.egip\n" +
            "\n" +
            "  egip.api.setAxiosDefaults({\n" +
            "    baseURL: 'http://example.com/'\n" +
            "  })\n" +
            "\n" +
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
            "    console.info(egipExamplesConfig[location.hostname]);\n" +
            "    const { pano_shape_3857, GKN_ZU_3857, egko_metro_3857 } = egipExamplesConfig[location.hostname];\n" +
            "    egip.api.setAxiosDefaults({\n" +
            "        baseURL: '/'\n" +
            "    });\n" +
            "    async function main() {\n" +
            "        await egip.api.login({\n" +
            "            login: 'sys',\n" +
            "            password: '123456'\n" +
            "        })\n" +
            "            .catch(err => console.warn(err));\n" +
            "        const map = egip.layers.createMap({\n" +
            "            target: 'map',\n" +
            "            controls: ol.control.defaults({\n" +
            "                attribution: false\n" +
            "            }),\n" +
            "        });";
}
