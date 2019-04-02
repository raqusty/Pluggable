workPath='/home/raqusty/Desktop/workPlace/buildApk'
projectPath='/media/raqusty/软件/linux/gitProject/Pluggable/app/src/main'
apkName='com/pluggable/raqusty/pluggable'

platformsPath='/home/raqusty/Android/Sdk/platforms/android-27'
buildToolPath='/home/raqusty/Android/Sdk/build-tools/27.0.3'

gradlePath='/home/raqusty/.gradle/caches/transforms-1/files-1.1'
modelPath='/home/raqusty/.gradle/caches/modules-2/files-2.1'

resName5=$gradlePath/'constraint-layout-1.1.3.aar/dae0907004a946c9d7968cc0979249ac/res'
resName11=$gradlePath/'appcompat-v7-27.1.1.aar/dbe4963dc756bdc74b363d49ec6ab110/res'
resName26=$gradlePath/'support-compat-27.1.1.aar/6573fa164b4c94943a88f1c7d8a76d61/res'
resName27=$gradlePath/'support-core-ui-27.1.1.aar/aadeccf3a78a2fccc7984d79192aa5a5/res'

javaName='classes.jar'

jarName1=$gradlePath/'runtime-1.1.0.aar/a1436fa3d6f12a64e34e2fd52e4fe1f6/jars'/$javaName
jarName2=$gradlePath/'livedata-core-1.1.0.aar/7bdb6fa6db0837b74beec3616176b211/jars'/$javaName
jarName3=$gradlePath/'runtime-1.1.0.aar/d038339b6132bdcd0ac36f25cd3571b8/jars'/$javaName
jarName4=$gradlePath/'viewmodel-1.1.0.aar/8b58019e8b98c10338027c59c07ff905/jars'/$javaName
jarName5=$gradlePath/'constraint-layout-1.1.3.aar/dae0907004a946c9d7968cc0979249ac/jars'/$javaName
jarName6=$gradlePath/'espresso-core-3.0.2.aar/a3e9c3f9a5852cc2f6714a10b026e79f/jars'/$javaName
jarName7=$gradlePath/'espresso-idling-resource-3.0.2.aar/3423f4a217bcc6a9cfc198a41dfd0cf9/jars'/$javaName
jarName8=$gradlePath/'monitor-1.0.2.aar/cd3f642049df6b63c4ae140b04e91299/jars'/$javaName
jarName9=$gradlePath/'runner-1.0.2.aar/613cefb3c4fe68237ca03820b260460f/jars'/$javaName
jarName10=$gradlePath/'animated-vector-drawable-27.1.1.aar/9c9924b5b34ffc2b19099c8358342d00/jars'/$javaName
jarName11=$gradlePath/'appcompat-v7-27.1.1.aar/dbe4963dc756bdc74b363d49ec6ab110/jars'/$javaName
jarName12=$gradlePath/'support-core-utils-27.1.1.aar/9e6b5c4ffd59f6553026e7bce6fdd3b4/jars'/$javaName
jarName13=$gradlePath/'support-fragment-27.1.1.aar/7c0e61447b5dc9c40e17832eb52b92f2/jars'/$javaName
jarName14=$gradlePath/'support-vector-drawable-27.1.1.aar/80281f8264c7211c4ba96cb2285b8cf2/jars'/$javaName

jarName15=$modelPath/'android.arch.core/common/1.1.0/8007981f7d7540d89cd18471b8e5dcd2b4f99167/common-1.1.0.jar'
jarName16=$modelPath/'android.arch.lifecycle/common/1.1.0/edf3f7bfb84a7521d0599efa3b0113a0ee90f85/common-1.1.0.jar'
jarName17=$modelPath/'com.google.code.findbugs/jsr305/2.0.1/516c03b21d50a644d538de0f0369c620989cd8f0/jsr305-2.0.1.jar'
jarName18=$modelPath/'com.squareup/javawriter/2.1.1/67ff45d9ae02e583d0f9b3432a5ebbe05c30c966/javawriter-2.1.1.jar'
jarName19=$modelPath/'javax.inject/javax.inject/1/6975da39a7040257bd51d21a231b76c915872d38/javax.inject-1.jar'
jarName20=$modelPath/'junit/junit/4.12/2973d150c0dc1fefe998f834810d68f278ea58ec/junit-4.12.jar'
jarName21=$modelPath/'org.hamcrest/hamcrest-integration/1.3/5de0c73fef18917cd85d0ab70bb23818685e4dfd/hamcrest-integration-1.3.jar'
jarName22=$modelPath/'org.hamcrest/hamcrest-core/1.3/42a25dc3219429f0e5d060061f71acb49bf010a0/hamcrest-core-1.3.jar'
jarName23=$modelPath/'org.hamcrest/hamcrest-library/1.3/4785a3c21320980282f9f33d0d1264a69040538f/hamcrest-library-1.3.jar'
jarName23=$modelPath/'org.hamcrest/hamcrest-library/1.3/4785a3c21320980282f9f33d0d1264a69040538f/hamcrest-library-1.3.jar'
jarName24=$modelPath/'com.android.support/support-annotations/27.1.1/39ded76b5e1ce1c5b2688e1d25cdc20ecee32007/support-annotations-27.1.1.jar'
jarName25=$modelPath/'com.android.support.constraint/constraint-layout-solver/1.1.3/bde0667d7414c16ed62d3cfe993cff7f9d732373/constraint-layout-solver-1.1.3.jar'

jarName26=$gradlePath/'support-compat-27.1.1.aar/6573fa164b4c94943a88f1c7d8a76d61/jars'/$javaName
jarName27=$gradlePath/'support-core-ui-27.1.1.aar/aadeccf3a78a2fccc7984d79192aa5a5/jars'/$javaName

jarName28='/opt/android-studio/gradle/m2repository/net/sf/kxml/kxml2/2.3.0'

#生成dex 
cd $buildToolPath
./dx --dex --output=$workPath/dex/classes.dex  $workPath/class  $jarName1 $jarName2 $jarName3 $jarName4 $jarName5 $jarName6 $jarName7 $jarName8 $jarName9 $jarName10 $jarName11 $jarName12 $jarName13 $jarName14 $jarName15 $jarName16 $jarName17 $jarName18 $jarName19 $jarName20 $jarName21 $jarName22 $jarName23 $jarName26 $jarName28 $jarName27 $jarName24 $jarName25

mv -f $workPath/dex/classes.dex $workPath/resources 
