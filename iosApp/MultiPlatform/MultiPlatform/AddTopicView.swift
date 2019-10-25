//
//  AddTopicView.swift
//  MultiPlatform
//
//  Created by Felizia Bernutz on 25.10.19.
//  Copyright © 2019 GDGNbgAndroid. All rights reserved.
//

import SwiftUI

struct AddTopicView: View {
	@State var title: String = ""
	@State var description: String = ""
	@Binding var topics: [MeetupTopic]
	@Environment(\.presentationMode) private var presentationMode: Binding<PresentationMode>

	var body: some View {
		VStack {
			TextField("Title", text: $title)
				.textFieldStyle(RoundedBorderTextFieldStyle())
				.padding()
			Divider()
			TextField("Description", text: $description)
				.textFieldStyle(RoundedBorderTextFieldStyle())
				.padding()
			Button(action: {

				let newTopic = MeetupTopic(
					id: self.topics.count + 1,
					name: self.title,
					description: self.description,
					isSelected: false)
				self.topics.append(newTopic)

				self.presentationMode.wrappedValue.dismiss()
			}) {
				HStack {
					Image(systemName: "checkmark")
					Text("Save")
				}
			}
		}
	}
}

struct AddTopicView_Previews: PreviewProvider {
	@State static var topics = mockTopics

	static var previews: some View {
		return AddTopicView(topics: $topics)
	}
}
