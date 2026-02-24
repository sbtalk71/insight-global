```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
                           http://www.springframework.org
                           http://www.springframework.org/schema/context 
                           http://www.springframework.org">

    <!-- Your context configuration elements go here, e.g., component-scan -->
    <context:component-scan base-package="com.yourpackage.service" />

</beans>

```
