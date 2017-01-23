package org.livespark.formmodeler.codegen.util; /**
 * Created by jsoltes on 12/2/16.
 */

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class CodegenTestUtils {

    public static File createJavaFile(String generatedSource, String path, String className) {
        File root = new File("src/test/resources");
        File sourceFile = new File(root, path+"/"+className);
        sourceFile.getParentFile().mkdirs();
        try {
            Files.write(sourceFile.toPath(), generatedSource.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceFile;
    }

    public static void compileFile (File sourceFile){
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, sourceFile.getPath());
    }
}
