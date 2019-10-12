//
//  ContentView.swift
//  MultiPlatform
//
//  Created by Felizia Bernutz on 12.10.19.
//  Copyright © 2019 GDGNbgAndroid. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        NavigationView {
            Form {
                Section {
                    ForEach(1 ..< 10 ) { row in
                        HStack {
                            VStack(alignment: .leading) {
                                Text("name \(row)")
                                    .font(.title)
                                Text("description \(row)")
                                    .font(.body)
                            }
                            Spacer()
                            Text("0")
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
