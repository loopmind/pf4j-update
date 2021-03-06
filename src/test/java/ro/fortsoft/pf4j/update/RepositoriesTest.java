/*
 * Copyright 2014 Decebal Suiu
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with
 * the License. You may obtain a copy of the License in the LICENSE file, or at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package ro.fortsoft.pf4j.update;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Decebal Suiu
 */
public class RepositoriesTest {

    private static final String repositoriesFile = "repositories.json";

    public static void main(String[] args) {
        FileWriter writer;
        try {
            writer = new FileWriter(repositoriesFile);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<UpdateRepository> repositories = new ArrayList<UpdateRepository>();
//        repositories.add(new UpdateRepository("local", "file:/home/decebal_suiu/work/pf4j-update/plugins/"));
        repositories.add(new UpdateRepository("localhost", "http://localhost:8081/"));
//        repositories.add(new UpdateRepository("localhost2", "http://localhost:8088/"));
//        repositories.add(new UpdateRepository("localhost3", "http://localhost:8888/"));

        String json = gson.toJson(repositories);
        try {
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
