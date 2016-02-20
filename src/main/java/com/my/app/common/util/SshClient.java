package com.my.app.common.util;

import static net.sf.expectit.filter.Filters.removeColors;
import static net.sf.expectit.filter.Filters.removeNonPrintable;
import static net.sf.expectit.matcher.Matchers.anyString;
import static net.sf.expectit.matcher.Matchers.contains;

import java.util.concurrent.TimeUnit;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import net.sf.expectit.Expect;
import net.sf.expectit.ExpectBuilder;

public class SshClient {

	public static void main(String[] args) throws Exception {
		JSch jSch = new JSch();
        Session session = jSch.getSession("stack", "10.0.0.101");
        session.setPassword("stack");
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        Channel channel = session.openChannel("shell");
        channel.connect();

        Expect expect = new ExpectBuilder()
                .withOutput(channel.getOutputStream())
                .withInputs(channel.getInputStream(), channel.getExtInputStream())
                .withTimeout(3, TimeUnit.SECONDS)
                .withInputFilters(removeColors(), removeNonPrintable())
                .withExceptionOnFailure()
                .build();
        try {
            System.out.println(expect.expect(anyString()).group().trim());
            expect.sendLine("pwd");
            System.out.println(expect.expect(contains("/home/stack")));
            //System.out.println(expect.expect(startsWith("/home/stack")));
        } finally {
            expect.close();
            channel.disconnect();
            session.disconnect();
        }
	}
	
}
