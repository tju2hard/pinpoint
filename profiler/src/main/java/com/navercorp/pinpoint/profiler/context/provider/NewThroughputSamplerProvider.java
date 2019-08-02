/*
 * Copyright 2019 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.profiler.context.provider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.navercorp.pinpoint.bootstrap.config.ProfilerConfig;
import com.navercorp.pinpoint.bootstrap.sampler.Sampler;
import com.navercorp.pinpoint.profiler.sampler.SamplerFactory;

/**
 * @author jaehong.kim
 */
public class NewThroughputSamplerProvider implements Provider<Sampler> {
    private final ProfilerConfig profilerConfig;

    @Inject
    public NewThroughputSamplerProvider(ProfilerConfig profilerConfig) {
        this.profilerConfig = profilerConfig;
    }

    @Override
    public Sampler get() {
        int throughput = profilerConfig.getSamplingNewThroughput();
        SamplerFactory samplerFactory = new SamplerFactory();
        return samplerFactory.createThroughputSampler(throughput);
    }
}