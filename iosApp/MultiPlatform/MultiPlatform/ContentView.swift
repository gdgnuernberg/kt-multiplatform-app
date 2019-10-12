//
//  ContentView.swift
//  MultiPlatform
//
//  Created by Felizia Bernutz on 12.10.19.
//  Copyright © 2019 GDGNbgAndroid. All rights reserved.
//

import SwiftUI
import SharedCode

struct ContentView: View {
    private let topics: [MeetupTopic] = Array(Repository().topics.values)

    var body: some View {
        NavigationView {
            Form {
                Section {
                    ForEach(topics, id: \.self) { topic in
                        HStack {
                            VStack(alignment: .leading) {
                                Text("\(topic.name)")
                                    .font(.title)
                                Text("\(topic.description)")
                                    .font(.body)
                            }
                            Spacer()
                            Text("\(topic.voteCount.count)")
                        }
                    }
                }
            }
            .navigationBarTitle("GDG Nuremberg Android", displayMode: .inline)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
