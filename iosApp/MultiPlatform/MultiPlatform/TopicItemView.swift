//
//  TopicItemView.swift
//  MultiPlatform
//
//  Created by Felizia Bernutz on 25.10.19.
//  Copyright © 2019 GDGNbgAndroid. All rights reserved.
//

import SwiftUI

struct TopicItemView: View {
	let topic: MeetupTopic
	var body: some View {
		HStack {
			VStack(alignment: .leading) {
				Text(topic.name)
					.font(.title)
				Text(topic.description ?? "")
					.font(.body)
			}
			Spacer()
			Image(systemName: topic.isSelected ? "heart.fill" : "heart")
				.padding()
				.scaleEffect(1.5)
				.foregroundColor(topic.isSelected ? .red : .black)
			Text("0")
		}
	}
}

struct TopicItemView_Previews: PreviewProvider {
	@State static var topics = mockTopics
	static var previews: some View {
		Group {
			TopicItemView(topic: topics[0])
				.previewLayout(.fixed(width: 414, height: 80))
			TopicItemView(topic: topics[1])
				.previewLayout(.fixed(width: 414, height: 80))
		}
	}
}
