//
//  ContentView.swift
//  MultiPlatform
//
//  Created by Felizia Bernutz on 12.10.19.
//  Copyright © 2019 GDGNbgAndroid. All rights reserved.
//

import SwiftUI

struct ContentView: View {
	@State var topics = mockTopics
	@State var isModal = false
	var body: some View {
		NavigationView {
			Form {
				Section {
					ForEach(topics) { row in
						TopicItemView(topic: row).onTapGesture {
							let index = self.topics.firstIndex(of: row)
							self.topics[index!].isSelected.toggle()
						}
					}
				}
			}
			.navigationBarTitle("GDG Nuremberg Android", displayMode: .inline)
			.navigationBarItems(trailing: Button(
					action: {
						self.isModal = true
					},
					label: { Image(systemName: "plus") }
			).sheet(isPresented: $isModal) {
				AddTopicView(topics: self.$topics)
			})
		}
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
