// swift-tools-version:5.7.1
import PackageDescription

let package = Package(
        name: "KMMApp",
 		    dependencies: [
 		        .package(url: "https://github.com/Mirzomuhsin2001/KMMApp.git", from: "1.0.0")
 		    ],
 		    targets: [
 		        .target(
 		            name: "KMMApp",
 		            dependencies: ["shared"]),
 		        .testTarget(
 		            name: "KMMAppTests",
 		            dependencies: ["KMMApp"]),
 		    ]
 		)