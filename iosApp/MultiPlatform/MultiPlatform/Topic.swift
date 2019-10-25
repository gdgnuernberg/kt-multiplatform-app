//
//  Topic.swift
//  MultiPlatform
//
//  Created by Felizia Bernutz on 25.10.19.
//  Copyright © 2019 GDGNbgAndroid. All rights reserved.
//

struct MeetupTopic: Identifiable, Hashable {
    let id: Int
    let name: String
    let description: String?
    var userVotings: Set<String> = []
    var isSelected: Bool
}

let mockTopics = [
    MeetupTopic(
        id: 1,
        name: "SwiftUI Workshop",
        description: "Was g'scheits",
        isSelected: true
    ),
    MeetupTopic(
        id: 2,
        name: "Kotlin Multiplatform Workshop",
        description: nil,
        isSelected: false
    )
]
