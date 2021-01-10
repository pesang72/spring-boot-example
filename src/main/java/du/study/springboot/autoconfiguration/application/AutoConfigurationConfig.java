package du.study.springboot.autoconfiguration.application;

import du.study.springboot.autoconfiguration.another.AnotherComponent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Import(AutoConfigurationConfig.MyImportSelector.class)
public class AutoConfigurationConfig {

    public static class MyImportSelector implements DeferredImportSelector,DeferredImportSelector.Group{
        private AnnotationMetadata meta;
        @Override
        public String[] selectImports (AnnotationMetadata importingClassMetadata) {
            return new String[]{MyImportSelector.class.getName()};
        }

        @Override
        public Class<? extends DeferredImportSelector.Group> getImportGroup() {
            return MyImportSelector.class;
        }

        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            meta = metadata;
        }

        @Override
        public Iterable<Entry> selectImports() {
            List<Entry> list = new ArrayList<>();
            list.add(new Entry(meta, AnotherComponent.class.getName()));
            return list;
        }
    }
}
