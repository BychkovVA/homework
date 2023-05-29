

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
//@AutoService(Processor.class)
public class ToStringProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(CustomToString.class)) {
            if (!(element instanceof TypeElement)) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "@CustomToString can only be applied to a class", element);
                continue;
            }
            TypeElement typeElement = (TypeElement) element;
            String className = typeElement.getQualifiedName().toString();
            String packageName = processingEnv.getElementUtils().getPackageOf(typeElement).toString();

            StringBuilder builder = new StringBuilder();
            builder.append("package ").append(packageName).append(";\n\n");
            builder.append("public class ").append(typeElement.getSimpleName()).append(" {\n\n");

            // Generate toString() method
            builder.append("  @Override\n");
            builder.append("  public String toString() {\n");
            builder.append("    return \"").append(className).append("[");
            for (Element e : typeElement.getEnclosedElements()) {
                if (e.asType().getKind().isPrimitive()) {
                    builder.append(e.getSimpleName()).append(" = \").append(")
                            .append(e.getSimpleName()).append(").append(\", ");
                }
            }
            builder.delete(builder.length() - 2, builder.length()); // remove last comma and space
            builder.append("]\";\n");
            builder.append("  }\n}\n");

            // Write generated class to file
            try {
                processingEnv.getFiler().createSourceFile(className + "ToString")
                        .openWriter()
                        .append(builder.toString())
                        .close();
            } catch (Exception e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "Failed to generate toString() method: " + e.getMessage(), element);
            }
        }
        return true;
    }

}
