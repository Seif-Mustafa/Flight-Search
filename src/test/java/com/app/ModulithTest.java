package com.app;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModulithTest {

    ApplicationModules modules = ApplicationModules.of(Application.class);

    @Test
    void verifyModulithStructure() {
        modules.verify();
    }
}
