#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html
#
Pod::Spec.new do |s|
  s.name             = 'system_setting'
  s.version          = '0.1.1'
  s.summary          = 'Flutter plugin for jumping to system settings.'
  s.description      = <<-DESC
Flutter plugin for jumping to system settings.
                       DESC
  s.homepage         = 'https://github.com/Edward608'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Edward Wong' => 'edwardwongtl@gmail.com' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.public_header_files = 'Classes/**/*.h'
  s.dependency 'Flutter'

  s.ios.deployment_target = '8.0'
end

