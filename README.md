SingleClick
===========
View 点击事件防抖处理，基于 AOP

默认的防抖时间间隔为 500 ms

latest version: v1.0.0

Usage
=====
1. 在 build.gradle 中添加 aspectjx classpath

        buildscript {
            ...
            
            dependencies {
                classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.4'
            }
        }
        
        allprojects {
            repositories {
                ...
                maven {
                    url "http://www.91chengguo.com:8081/repository/maven-releases/"
                }
                maven {
                    url "http://www.91chengguo.com:8081/repository/maven-snapshots/"
                }
            }
        }

        
2. 在 app/build.gradle 中添加依赖

        apply plugin: 'com.hujiang.android-aspectjx'

        ...
        
        dependencies {
            implementation 'com.orange.note:singleclick:1.0.0'
        }
        
        
3. 如果有不需要做防抖处理的地方，添加 @Except 即可。比如 :

        button.setOnClickListener(new View.OnClickListener() {
            
            @Except
            @Override
            public void onClick(View v) {
                // do something
            }
        });
        
4. 支持设置自定义防抖时间，单位为 ms

        SingleClickManager.getInstance().setClickTimeInterval(300);
        
Proguard
=========

    -keep com.orange.note.singleclick.** {*;}
    
TODO
====
1. add onItemClick throttle click event
        
changelog
=========
* v1.0.0 init commit

