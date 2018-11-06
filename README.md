# system_setting

[![pub package](version_image.svg)](https://pub.dartlang.org/packages/system_setting)

A Flutter plugin for jumping to system settings. Currently support Android only. iOS support is coming soon.

## Usage

To use this plugin, add `system_setting` as a [dependency in your pubspec.yaml file](https://flutter.io/platform-plugins/).

### Example

```dart
import 'package:flutter/material.dart';
import 'packages:system_setting/system_setting.dart';

void main() => runApp(Scaffold(
      body: Center(
        child: RaisedButton(
          onPressed: _jumpToSetting,
          child: Text('Show Flutter homepage'),
        ),
      ),
    ));

_jumpToSetting() {
  SystemSetting.goto(SettingTarget.WIFI);
}
```