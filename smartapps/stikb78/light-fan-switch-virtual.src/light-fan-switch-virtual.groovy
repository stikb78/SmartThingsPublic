/**
 *  Light Fan Switch (Virtual)
 *
 *  Copyright 2021 Bernadette Mudford
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "Light Fan Switch (Virtual)",
    namespace: "stikb78",
    author: "Bernadette Mudford",
    description: "Testing viablity of 3 speed fan and light switch\r\n",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
	section("Turn on this light") {
        input "thelightswitch", "capability.switch", required: true
    }

}

def installed() {
	log.debug "Installed with settings: ${settings}"

	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	initialize()
}

def initialize() {
	// TODO: subscribe to attributes, devices, locations, etc.
    log.debug "init"
    subscribe(thelightswitch, "switch.on", switchOnHandler)
    log.debug "Subscribed thelightswitch.on"
    subscribe(thelightswitch, "switch.off", switchOffHandler)
    log.debug "Subscribed thelightswitch.on"

    
}

// TODO: implement event handlers
def switchOnHandler(evt) {
    log.debug "switchOnHandler called: $evt"
    thelightswitch.on()
    }
    
    def switchOffHandler(evt) {
    log.debug "switchOffHandler called: $evt"
    thelightswitch.off()
    }